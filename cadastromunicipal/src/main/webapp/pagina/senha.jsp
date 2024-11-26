<!DOCTYPE html>
<html lang="pt-br">
<meta charset="UTF-8">
<title>CMPCD</title>
<link rel="stylesheet" type="text/css" href="senha.css">
<link rel="stylesheet" type="text/css" href="senhaGlobal.css">
</head>

<body>
    <header>
        <div class="ordem-header">
            <div class="primeiro-header">
                <a href="/cadastromunicipal/page?pagina=inicial" class="align">Lorem ipsum dolor</a>
            </div>
        </div>
    </header>

    <section class="align">

        <form class="section-template align" action="/cadastromunicipal/controleuser?acao=atualizar-senha"
            method="POST">
            <input type="hidden" name="codigo" value="${usuarioPcd.codigo}">
            <h2>Confirmar Senha</h2>
            <div class="formulario align">
                <div class="ordem-formulario">
                    <label for="senha">senha:</label>
                    <label for="confirmarsenha">confirmar senha:</label>
                </div>
                <div class="ordem-formulario">
                    <input type="password" name="senha" id="senha" required minlength="8">
                    <input type="password" name="confirmarsenha " id="confirmarsenha" required minlength="8">
                </div>
            </div>

            <button type="submit" class="btt-section-template align green-color" id="btt-confirmar">Confirmar</button>
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