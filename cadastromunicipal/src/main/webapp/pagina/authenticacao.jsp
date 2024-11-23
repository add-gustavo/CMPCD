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
                <a href="/cadastromunicipal/inicial.jsp" class="align">Lorem ipsum dolor</a>
            </div>
        </div>

    </header>

    <section class="centerY">

        <div class="section-template align">
            <h2>Authenticação</h2>

            <form class="centerY" action="/cadastromunicipal/controleuser?acao=excluir-conta" method="POST">
                <div class="formulario">

                    <div class="ordem-formulario align">
                        <label for="email">email</label>
                        <label for="senha">senha</label>
                    </div>
                    <div class="ordem-formulario align">
                        <input type="text" name="email" id="email" required autofocus>
                        <input type="password" name="senha" id="senha" required minlength="8">
                    </div>
                </div>
                <div>
                    <button type="submit" class="btt-section-template align green-color">Entrar</button>
                </div>
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
<script src="inicial.js"></script>

</html>