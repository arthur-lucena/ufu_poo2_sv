package edu.ufu.poo2.si.control;

import edu.ufu.poo2.si.control.utils.FactoryConnection;
import edu.ufu.poo2.si.model.Vendedor;
import edu.ufu.poo2.si.util.EnumNivelVendedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO {

    private FactoryConnection fc;
    private String tabela = "vendedor";
    private String columns = "cpf, "
            + "nome_cliente, "
            + "nivel ";

    public VendedorDAO() {
        this.fc = FactoryConnection.getInstance();
    }

    public List<Vendedor> buscarTodos() {
        List<Vendedor> retorno = new ArrayList<>();

        try {
            PreparedStatement stmt = fc.getConnection().prepareStatement("select * from " + tabela);

            ResultSet rs = stmt.executeQuery();

            Vendedor vendedor;

            while (rs.next()) {
                vendedor = new Vendedor();
                vendedor.setCPF(rs.getString("cpf"));
                vendedor.setNome(rs.getString("nome_cliente"));
                vendedor.setNivel(EnumNivelVendedor.getNivel(rs.getInt("nivel")));

                retorno.add(vendedor);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public Vendedor buscar(String cpf) {
        Vendedor retorno = new Vendedor();

        try {
            PreparedStatement stmt = fc.getConnection().prepareStatement("select * from " + tabela + " where cpf = ?");
            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                retorno.setCPF(rs.getString("cpf"));
                retorno.setNome(rs.getString("nome_cliente"));
                retorno.setNivel(EnumNivelVendedor.getNivel(rs.getInt("nivel")));
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

    public Vendedor insert(Vendedor v) {
        String sql = "insert into " + tabela + "(" + columns + ") " + "values (?,?,?)";

        PreparedStatement stmt;

        try {
            stmt = fc.getConnection().prepareStatement(sql);

            stmt.setString(1, v.getCPF());
            stmt.setString(2, v.getNome());
            stmt.setInt(3, v.getNivel().ordinal());

            stmt.execute();
            stmt.close();

            fc.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return v;
    }

    public Vendedor update(Vendedor v) {
        String sql = "update " + tabela + " set nome_cliente = ?, nivel = ? where cpf = ?";

        PreparedStatement stmt;

        try {
            stmt = fc.getConnection().prepareStatement(sql);

            stmt.setString(1, v.getNome());
            stmt.setInt(2, v.getNivel().ordinal());
            stmt.setString(3, v.getCPF());

            stmt.execute();
            stmt.close();

            fc.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return v;
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
