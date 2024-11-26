<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <title>CMPCD</title>
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css" href="inicialGlobal.css">
            <link rel="stylesheet" type="text/css" href="inicial.css">
        </head>

        <body>

            <header>
                <div class="ordem-header">
                    <div class="primeiro-header">
                        <a href="" class="logo align">
                            <div>
                                <span class="blue-text">C</span><span class="green-text">M</span><span
                                    class="yellow-text">P</span><span class="orange-text">C</span><span
                                    class="red-text">D</span>
                            </div>
                        </a>
                        <div class="ordem-perfil-button">
                            <c:choose>
                                <c:when test="${not empty sessionScope.usuarioPcd}">
                                    <input type="hidden" name="usuarioPcd" value="${usuarioPcd}">
                                    <a class="perfil-button align"
                                        href="/cadastromunicipal/controleuser?acao=atualizar-perfil">Meu Perfil</a>
                                </c:when>
                                <c:otherwise>
                                    <!-- Se o usuário não estiver logado, mostrar o link para login -->
                                    <a class="perfil-button align"
                                        href="/cadastromunicipal/page?pagina=login">Entrar</a>
                                </c:otherwise>
                            </c:choose>
                        </div>

                    </div>
                    <div class="green-color segunda-header align">
                        <div class="ordem-template-header align">
                            <a href="/cadastromunicipal/page?pagina=relatorio" class="header-button">Relatorio</a>
                            <a class="header-button">Sobre Nós</a>
                            <a class="header-button">Ajuda</a>
                        </div>
                    </div>
                </div>
            </header>
            <main>
                <section class="search-bar align">
                    <input type="text" id="fpesquisa" required autofocus>
                </section>

                <section class="section-template align">
                    <img id="img-section-template"
                        src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3YznLlPf_Cgc7I7h7bGdx4GS-6hhEcO_4oQ&s">
                    <div class=" ordem-texto">
                        <a class="align">Lorem ipsum, dolor sit amet consectetur adipisicing elit.</a>
                        <p id="text-section-template" class="justify">Lorem ipsum dolor sit amet consectetur adipisicing
                            elit.
                            Asperiores quis
                            libero aliquid, cumque
                            dolores fuga reiciendis iste quo nemo dolor molestiae, rem aspernatur nostrum maxime vel,
                            alias
                            suscipit porro! Hic!</p>
                    </div>
                </section>

                <section class="carrossel">
                    <button class="pre-btn"><img src="arrow.png" alt=""></button>
                    <button class="nxt-btn"><img src="arrow.png" alt=""></button>
                    <div class="box-container">
                        <div class="box-card blue-color">
                            <div class="box-image">
                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3YznLlPf_Cgc7I7h7bGdx4GS-6hhEcO_4oQ&s"
                                    class="box-thumb" alt="">
                            </div>
                            <div class="box-info align">
                                <a class="carrossel-text">brand</a>
                            </div>
                        </div>
                        <div class="box-card orange-color">
                            <div class="box-image">
                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3YznLlPf_Cgc7I7h7bGdx4GS-6hhEcO_4oQ&s"
                                    class="box-thumb" alt="">
                            </div>
                            <div class="box-info align">
                                <a class="carrossel-text">brand</a>
                            </div>
                        </div>
                        <div class="box-card red-color">
                            <div class="box-image">
                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3YznLlPf_Cgc7I7h7bGdx4GS-6hhEcO_4oQ&s"
                                    class="box-thumb" alt="">
                            </div>
                            <div class="box-info align">
                                <a class="carrossel-text">brand</a>
                            </div>
                        </div>
                        <div class="box-card yellow-color">
                            <div class="box-image">
                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3YznLlPf_Cgc7I7h7bGdx4GS-6hhEcO_4oQ&s"
                                    class="box-thumb" alt="">
                            </div>
                            <div class="box-info align">
                                <a class="carrossel-text">brand</a>
                            </div>
                        </div>
                        <div class="box-card red-color">
                            <div class="box-image">
                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3YznLlPf_Cgc7I7h7bGdx4GS-6hhEcO_4oQ&s"
                                    class="box-thumb" alt="">
                            </div>
                            <div class="box-info align">
                                <a class="carrossel-text">brand</a>
                            </div>
                        </div>
                        <div class="box-card blue-color">
                            <div class="box-image">
                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3YznLlPf_Cgc7I7h7bGdx4GS-6hhEcO_4oQ&s"
                                    class="box-thumb" alt="">
                            </div>
                            <div class="box-info align">
                                <a class="carrossel-text">brand</a>
                            </div>
                        </div>
                        <div class="box-card orange-color">
                            <div class="box-image">
                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3YznLlPf_Cgc7I7h7bGdx4GS-6hhEcO_4oQ&s"
                                    class="box-thumb" alt="">
                            </div>
                            <div class="box-info align">
                                <a class="carrossel-text">brand</a>
                            </div>
                        </div>
                        <div class="box-card red-color">
                            <div class="box-image">
                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3YznLlPf_Cgc7I7h7bGdx4GS-6hhEcO_4oQ&s"
                                    class="box-thumb" alt="">
                            </div>
                            <div class="box-info align">
                                <a class="carrossel-text">brand</a>
                            </div>
                        </div>
                        <div class="box-card yellow-color">
                            <div class="box-image">
                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3YznLlPf_Cgc7I7h7bGdx4GS-6hhEcO_4oQ&s"
                                    class="box-thumb" alt="">
                            </div>
                            <div class="box-info align">
                                <a class="carrossel-text">brand</a>
                            </div>
                        </div>
                        <div class="box-card red-color">
                            <div class="box-image">
                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3YznLlPf_Cgc7I7h7bGdx4GS-6hhEcO_4oQ&s"
                                    class="box-thumb" alt="">
                            </div>
                            <div class="box-info align">
                                <a class="carrossel-text">brand</a>
                            </div>
                        </div>
                    </div>
                </section>
                <section class="section-text-box align">
                    <p class="text-section-text-box align-text">Registre-se no sistema e mantenha seu perfil atualizado
                        para que
                        possamos entender
                        suas necessidades e
                        oferecer os serviços mais adequados. O cadastro é simples e seguro, e você pode incluir
                        informações como
                        tipo de deficiência, necessidades específicas, e preferências de atendimento.</p>
                </section>
            </main>
            <footer class="green-color align">
                <div></div>
                <div>
                    <ul>
                        <li>Instagram</li>
                        <li>Facebook</li>
                        <li>Contato</li>
                        <li>etc...</li>
                    </ul>
                </div>
            </footer>

            <script src="inicial.js"></script>
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