package com.br.cmpcd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import DAO.ControlUsuario;
import DTO.Pessoa;
import DTO.Usuario;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.cmpcd.dao.util.Conexao;

public class ControleBd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    };

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        requisicao(request, response);
        // Código para lidar com a requisição POST
    }

    private void requisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao == null || acao.isEmpty()) {
            response.sendRedirect("erro.html"); // ou redirecionar para uma página de erro ou login
            return;
        }

        try {
            switch (acao) {

                case "fazer-login":
                    fazerLogin(request, response);
                    break;

                case "fazer-cadastro":
                    novoUsuarioPCD(request, response);
                    break;

                case "finalizar-cadastro":
                    cadastroFinalizado(request, response);
                    break;
                default:
                    break;
            }
        } catch (ServletException e) {
        }

    };

    private void fazerLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtém a conexão com o banco de dados
        Connection conexaoJDBC = Conexao.getConexao();

        // Cria o objeto Usuario com os parâmetros do formulário
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Usuario usuario = new Usuario(email, senha);

        // Controlador de Usuário
        ControlUsuario objuser = new ControlUsuario(conexaoJDBC);

        // Realiza a autenticação do usuário
        ResultSet rsusuario = objuser.authentificacaoUsuario(usuario);

        try {
            // Verifica se a autenticação foi bem-sucedida
            if (rsusuario.next()) {
                // Autenticação bem-sucedida, pega o nome de login do usuário
                String nomelogin = rsusuario.getString("nome_login"); // Ou o nome da coluna no seu banco de dados

                // Passa o nome de login para a página inicial
                request.setAttribute("nome_usuario", nomelogin);

                // Redireciona para a página inicial
                RequestDispatcher dispatcher = request.getRequestDispatcher("inicial.jsp");
                dispatcher.forward(request, response); // Redireciona para a página inicial
            } else {
                // Autenticação falhou, redireciona para a página de login com erro
                request.setAttribute("erroLogin", "E-mail ou senha inválidos."); // Mensagem de erro
                RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/login.jsp");
                dispatcher.forward(request, response); // Redireciona para o login
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Em caso de erro no banco de dados ou exceção, exibe uma página de erro
            // genérica
            request.setAttribute("erro", "Erro ao processar login.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/erro.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void novoUsuarioPCD(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nomelogin");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String confirmarsenha = request.getParameter("confirmar-senha");

        // Validação simples de campos obrigatórios
        if (nome == null || email == null || senha == null || confirmarsenha == null || nome.isEmpty()
                || email.isEmpty() || senha.isEmpty() || confirmarsenha.isEmpty()) {
            request.setAttribute("erro", "Todos os campos são obrigatórios.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/cadastrop1.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Verifica se as senhas coincidem
        if (!confirmarsenha.equals(senha)) {
            request.setAttribute("erro", "As senhas não coincidem. Tente novamente.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/cadastrop1.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Validação do formato do email (simplificada)
        if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            request.setAttribute("erro", "O email informado é inválido.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/cadastrop1.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Redirecionar para a próxima página com os dados inseridos
        request.setAttribute("nome", nome);
        request.setAttribute("email", email);
        request.setAttribute("senha", senha);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/cadastro.jsp");
        dispatcher.forward(request, response);
    }

    private void cadastroFinalizado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomelogin = request.getParameter("nomelogin");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        System.out.println(nomelogin + email + senha);

        // Verificar se os campos obrigatórios estão preenchidos
        if (nomelogin == null || email == null || senha == null || nomelogin.isEmpty() || email.isEmpty()
                || senha.isEmpty()) {
            request.setAttribute("erro", "Todos os campos são obrigatórios.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/cadastrop1.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Restante dos parâmetros

        String nomeCompleto = request.getParameter("nomecompleto");
        String cpf = request.getParameter("cpf");
        String tipoDeficiencia = request.getParameter("tipoDeficiencia");
        String grauDeficiencia = request.getParameter("grauDeficiencia");
        String dataNascimento = request.getParameter("dataNascimento");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        String ocupacao = request.getParameter("ocupacao");
        String genero = request.getParameter("genero");
        String estadoCivil = request.getParameter("estadoCivil");
        String nivelEscolaridade = request.getParameter("nivelEscolaridade");
        String historicoMedicoRelevante = request.getParameter("historicoMedico");
        boolean programaAssistenciaSocial = Boolean.parseBoolean(request.getParameter("programaAssistenciaSocial"));
        boolean necessidadeAcompanhante = Boolean.parseBoolean(request.getParameter("necessidadeAcompanhante"));
        boolean necessidadeEquipamento = Boolean.parseBoolean(request.getParameter("necessidadeEquipamento"));
        boolean necessidadeTransporteAdaptado = Boolean
                .parseBoolean(request.getParameter("necessidadeTransporteAdaptado"));
        boolean necessidadeAdaptacaoLocalAtendimento = Boolean
                .parseBoolean(request.getParameter("necessidadeAdaptacaoLocalAtendimento"));
        boolean necessidadeApoioEducacional = Boolean.parseBoolean(request.getParameter("necessidadeApoioEducacional"));
        double rendaFamiliarPCapita = Double.parseDouble(request.getParameter("rendaFamiliarPCapita"));
        boolean usoMedicacao = Boolean.parseBoolean(request.getParameter("usoMedicacao"));
        boolean participaCentroApoio = Boolean.parseBoolean(request.getParameter("participaCentroApoio"));
        boolean atendimentoEspecialista = Boolean.parseBoolean(request.getParameter("atendimentoEspecialista"));

        // Criação do objeto Pessoa
        Pessoa pessoa = new Pessoa(nomelogin, email, senha, nomeCompleto, cpf,
                dataNascimento, tipoDeficiencia, endereco, ocupacao,
                genero, estadoCivil, grauDeficiencia, necessidadeAcompanhante,
                necessidadeEquipamento, necessidadeTransporteAdaptado,
                necessidadeAdaptacaoLocalAtendimento, nivelEscolaridade,
                necessidadeApoioEducacional, rendaFamiliarPCapita,
                programaAssistenciaSocial, historicoMedicoRelevante, usoMedicacao,
                participaCentroApoio, atendimentoEspecialista, telefone);

        try {
            // Salvar a pessoa no banco
            ControlUsuario control = new ControlUsuario(Conexao.getConexao());
            control.adicionarUsuario(pessoa);

            // Redirecionar para página de sucesso
            request.setAttribute("nome_usuario", nomelogin);
            RequestDispatcher dispatcher = request.getRequestDispatcher("inicial.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            // Se ocorrer um erro ao adicionar no banco de dados, exibir mensagem de erro
            request.setAttribute("erro", "Erro ao cadastrar o usuário. Tente novamente.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pagina/cadastrop1.jsp");
            dispatcher.forward(request, response);
        }
    }

}