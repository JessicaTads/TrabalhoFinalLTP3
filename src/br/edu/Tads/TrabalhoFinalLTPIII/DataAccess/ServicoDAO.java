/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jessica
 */
/*public class ServicoDAO extends DAO {

    public ServicoDAO() {
        super();
    }

    public boolean Salvar(Servico obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into Servicos(descricao,valor,formaPagamento,IdProduto,data,IdAgendamento,IdCliente,idFuncionario) values(?,?,?,?,?,?,?,?)");
                sql.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sql.setDouble(2, obj.getValor());
                sql.setString(3, obj.getFormapagamento());
                sql.setString(4, obj.getDescricao());
                sql.setInt(5, obj.getAgendamento().getCodigo());
                sql.setInt(6, obj.getProduto().getCodProduto());
                sql.setInt(7, obj.getFuncionario().getCodigo());
                sql.setInt(8, obj.getCliente().getCodigo());
                sql.executeUpdate();

                PreparedStatement sqlConsulta = getConexao().prepareStatement("select IdServico from Servicos where descricao=? and valor=? and Data=? and formaPagamento=? and idAgendamento=? and IdProduto=? and "
                        + "IdFuncionario=? and IdCliente=?");

                sqlConsulta.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sqlConsulta.setDouble(2, obj.getValor());
                sqlConsulta.setString(3, obj.getFormapagamento());
                sqlConsulta.setString(4, obj.getDescricao());
                sqlConsulta.setInt(5, obj.getAgendamento().getCodigo());
                sqlConsulta.setInt(6, obj.getProduto().getCodProduto());
                sqlConsulta.setInt(7, obj.getFuncionario().getCodigo());
                sqlConsulta.setInt(8, obj.getCliente().getCodigo());

                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("Idervico"));
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Servicos set IdServico from Servicos where descricao=? and valor=? and Data=? and formaPagamento=? and idAgendamento=? and IdProduto=? and "
                        + "IdFuncionario=? and IdCliente=?");
                sqlUpdate.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sqlUpdate.setDouble(2, obj.getValor());
                sqlUpdate.setString(3, obj.getFormapagamento());
                sqlUpdate.setString(4, obj.getDescricao());
                sqlUpdate.setInt(5, obj.getAgendamento().getCodigo());
                sqlUpdate.setInt(6, obj.getProduto().getCodProduto());
                sqlUpdate.setInt(7, obj.getFuncionario().getCodigo());
                sqlUpdate.setInt(8, obj.getCliente().getCodigo());
                sqlUpdate.setInt(7, obj.getCodigo());

                sqlUpdate.executeUpdate();
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
            
        }
    }

    

    public Servico Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Servicos where IdServico=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Servico obj = new Servico();
                FuncionarioDAO funcionario = new FuncionarioDAO();
                ClienteDAO cliente = new ClienteDAO();

                CarregaObjetoServico(obj, resultado, cliente, funcionario);

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    
    public List<Servico> ListarServicos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Servicos");

            ResultSet resultado = sql.executeQuery();

            List<Servico> lista = new ArrayList<Servico>();

            while (resultado.next()) {
                Servico obj = new Servico();
                
                FuncionarioDAO funcionario = new FuncionarioDAO();
                ClienteDAO cliente = new ClienteDAO();

                CarregaObjetoServico(obj, resultado, cliente, funcionario);

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    
    
    

    protected void CarregaObjetoServico(Servico obj, ResultSet resultado, ClienteDAO cliente, FuncionarioDAO funcionario) throws SQLException, Exception {
        obj.setCodigo(resultado.getInt("IdServico"));
        obj.setData(resultado.getDate("Data"));
        obj.setValor(resultado.getDouble("Valor"));
        obj.setFormapagamento(resultado.getString("formapagamento"));
        obj.setDescricao(resultado.getString("Descricao"));
        obj.setCliente(cliente.AbrirCliente(resultado.getInt("IdCliente")));
        obj.setFuncionario(funcionario.AbrirFuncionario(resultado.getInt("IdFuncionario")));
        obj.setFuncionario(funcionario.AbrirFuncionario(resultado.getInt("IdFuncionario")));
    }
}
*/