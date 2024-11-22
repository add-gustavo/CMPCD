<!DOCTYPE html>
<html lang="pt-br">
<meta charset="UTF-8">
<title>CMPCD</title>
<link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/cadastrop1.css">
<link rel="stylesheet" type="text/css" href="/cadastromunicipal/pagina/css/cadastrop1Global.css">
</head>

<body>
    <header class="green-color">
        <div class="ordem-header">
            <div class="primeiro-header">
                <a class="logo align">Lorem ipsum dolor</a>
            </div>
        </div>

    </header>

    <section class="centerY">

        <div class="section-template align">
            <h2>Cadastre-se</h2>
            <form class="align" action="/cadastromunicipal/controlebd?acao=fazer-cadastro" method="POST">
                <div class="formulario">
                    <div class="ordem-formulario">
                        <label for="nomelogin">nome de login</label>
                        <label for="email">email</label>
                        <label for="senha">senha</label>
                        <label for="confirmar-senha">Confirmar senha</label>
                    </div>
                    <div class="ordem-formulario align">
                        <input type="text" name="nomelogin" id="nomelogin">
                        <input type="text" name="email" id="email" required autofocus>
                        <input type="password" name="senha" id="senha" required minlength="8">
                        <input type="password" name="confirmar-senha" id="confirmar-senha" required minlength="8">
                    </div>
                </div>

                <button type="submit" class=" btt-section-template align green-color">Proximo</button>
            </form>

        </div>


    </section>
    <footer class="green-color align">

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