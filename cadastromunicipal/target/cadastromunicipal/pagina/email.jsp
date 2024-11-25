<!DOCTYPE html>
<html lang="pt-br">
<meta charset="UTF-8">
<title>CMPCD</title>
<link rel="stylesheet" type="text/css" href="email.css">
<link rel="stylesheet" type="text/css" href="emailGlobal.css">
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

        <form class="section-template align" action="/cadastromunicipal/controleuser?acao=atualizar-email"
            method="POST">
            <input type="hidden" name="codigo" value="${usuarioPcd.codigo}">
            <h2>Confirmar Email</h2>
            <div class="formulario align">
                <div class="ordem-formulario">
                    <label for="email">email:</label>
                    <label for="confirmaremail">confirmar email:</label>
                </div>
                <div class="ordem-formulario">
                    <input type="text" name="email" id="email" required autofocus>
                    <input type="text" name="confirmaremail " id="confirmaremail" required autofocus>
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
<script src="inicial.js"></script>

</html>