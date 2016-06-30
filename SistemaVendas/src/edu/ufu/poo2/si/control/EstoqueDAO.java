package edu.ufu.poo2.si.control;

import edu.ufu.poo2.si.control.utils.FactoryConnection;
import edu.ufu.poo2.si.model.Estoque;
import edu.ufu.poo2.si.util.enums.EnumEstadoEstoque;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {

    private FactoryConnection fc;
    private String tabela = "estoque";
    private String columnPk = "produto_codigo";
    private String columns = "qtd, "
    		+ "qtd_reservada, "
    		+ "estado_estoque";

    public EstoqueDAO() {
        this.fc = FactoryConnection.getInstance();
    }

    public List<Estoque> buscarTodos() {
        List<Estoque> retorno = new ArrayList<>();

        try {
            PreparedStatement stmt = fc.getConnection().prepareStatement("select * from " + tabela);

            ResultSet rs = stmt.executeQuery();

            Estoque estoque;

            while (rs.next()) {
                estoque = new Estoque();
                estoque.setCodigoEstoque(rs.getLong("codigo_estoque"));
                estoque.setQuantidade(rs.getInt("qtd"));
                estoque.setQuantidadeReservada(rs.getInt("qtd_reservada"));
                estoque.setEstadoEstoque(EnumEstadoEstoque.getEstadoEstoque(rs.getInt("estado_estoque")));

                retorno.add(estoque);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public Estoque buscar(Long codigoEstoque) {
        Estoque retorno = new Estoque();

        String sql = "select * from " + tabela 
        		+ " where " + columnPk + " = ?";
        
        try {
            PreparedStatement stmt = fc.getConnection().prepareStatement(sql);
            stmt.setLong(1, codigoEstoque);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
            	retorno.setCodigoEstoque(rs.getLong("codigo_estoque"));
            	retorno.setQuantidade(rs.getInt("qtd"));
            	retorno.setQuantidadeReservada(rs.getInt("qtd_reservada"));
            	retorno.setEstadoEstoque(EnumEstadoEstoque.getEstadoEstoque(rs.getInt("estado_estoque")));
            } else {
                return null;
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public Estoque insert(Estoque c) {
        String sql = "insert into " + tabela + "(" + columns + ") " + "values (?,?)";

        PreparedStatement stmt;

        try {
            stmt = fc.getConnection().prepareStatement(sql);

            stmt.setString(1, c.getCPF());
            stmt.setString(2, c.getNome());

            stmt.execute();
            stmt.close();

            fc.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public Estoque update(Estoque c) {
        String sql = "update " + tabela + " set nome_Estoque = ? where cpf = ?";

        PreparedStatement stmt;

        try {
            stmt = fc.getConnection().prepareStatement(sql);

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCPF());

            stmt.execute();
            stmt.close();

            fc.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public void delete(String cpf) {
        String sql = "delete from " + tabela + " where cpf = ?";

        PreparedStatement stmt;

        try {
            stmt = fc.getConnection().prepareStatement(sql);

            stmt.setString(1, cpf);

            stmt.execute();
            stmt.close();

            fc.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
