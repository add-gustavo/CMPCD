<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <title>CMPCD</title>
            <link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/authenticacao.css">
            <link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/authenticacaoGlobal.css">
        </head>

        <body>
            <header>
                <div class="ordem-header">
                    <div class="primeiro-header">
                        <a href="/cadastromunicipal/page?pagina=inicial" class="logo align">
                            <div>
                                <span class="blue-text">C</span><span class="green-text">M</span><span
                                    class="yellow-text">P</span><span class="orange-text">C</span><span
                                    class="red-text">D</span>
                            </div>
                        </a>
                    </div>
                </div>

            </header>

            <section class="align">

                <form class="section-template align" action="/cadastromunicipal/authentificacao" method="POST">
                    <h2>Authenticação</h2>
                    <div class="formulario">
                        <div class="ordem-formulario">
                            <label for="email">email</label>
                            <label for="senha">senha</label>
                        </div>
                        <div class="ordem-formulario">
                            <input type="text" name="email" id="email" required autofocus>
                            <input type="password" name="senha" id="senha" required minlength="8">
                        </div>
                    </div>

                    <input type="hidden" name="acao" value="${param.acao}">


                    <button type="submit" class="btt-section-template align green-color">Authentificar</button>

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

            <div vw class="enabled">
                <div vw-access-button class="active"></div>
                <div vw-plugin-wrapper>
                    <div class="vw-plugin-top-wrapper"></div>
                </div>
            </div>
            <script src="https://vlibras.gov.br/app/vlibras-plugin.js"></script>
            <script>
                new window.VLibras.Widget('https://vlibras.gov.br/app');
            </script>

        </body>

        </html>