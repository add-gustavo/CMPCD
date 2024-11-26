<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <title>CMPCD</title>
            <link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/login.css">
            <link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/loginGlobal.css">
        </head>

        <body>
            <header>
                <div class="ordem-header">
                    <div class="primeiro-header">
                        <a href="/cadastromunicipal/page?pagina=inicial" class="align">Lorem ipsum dolor</a>
                    </div>
                </div>

            </header>

            <section class="centerY">

                <div class="section-titulo centerX">

                    <div class="section-cadastro">
                        <span class="text-cadastro">Possui Cadastro</span>
                        <a href="/cadastromunicipal/page?pagina=cadastro">Cadastrar-se</a>

                    </div>
                </div>


                <form class="section-template align" action="/cadastromunicipal/controleuser?acao=fazer-login"
                    method="POST">
                    <h2>Login</h2>
                    <div class="formulario align">
                        <div class="ordem-formulario align">
                            <label for="email">email</label>
                            <label for="senha">senha</label>
                        </div>
                        <div class="ordem-formulario align">
                            <input type="text" name="email" id="email" required autofocus>
                            <input type="password" name="senha" id="senha" required minlength="8">
                        </div>
                    </div>

                    <button type="submit" class="btt-section-template align green-color">Entrar</button>
                </form>



            </section>
            <footer class="align">

                <div>

                </div>
                <div>
                    <ul>
                        <li>Instagram</li>
                        <li>Facebook</li>
                        <li>Contato</li>
                        <li>etc...</li>
                    </ul>
                </div>


            </footer>

        </body>

        </html>