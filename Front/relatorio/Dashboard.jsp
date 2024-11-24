<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Gráficos e Dados</title>
            <link rel="stylesheet" href="/cadastromunicipal/css/Dasboard.css?v=1.0">
            <style>
                @import url('https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&display=swap');
            </style>
            <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

        </head>

        <body>
            <header>
                <a href="#">CMPCD</a>
                <a href="#">Entrar</a>
            </header>
            <nav>
                <ul class="listanav">
                    <li><a href="#">Perfil</a></li>
                    <li><a href="#">Sobre Nós</a></li>
                    <li><a href="#">Ajuda</a></li>
                    <li><a href="#">Gráficos</a></li>
                </ul>
            </nav>

            <div class="container-geral">
                <!-- Contêiner para os gráficos de pizza à esquerda -->
                <div class="container-pizza">
                    <canvas id="pieChart1"></canvas>
                    <canvas id="pieChart2"></canvas>
                </div>

                <!-- Gráfico principal ao lado direito -->
                <canvas id="lineChart"></canvas>
            </div>

            <footer>
                <div class="align-footer">
                    <a href="#">CMPCD</a>
                    <p>Entre em contato com o suporte <br>
                        xxxxx@gmail.com
                    </p>
                </div>
            </footer>

            <script src="/cadastromunicipal/js/Dasboard.js?v=1.0"></script>

        </body>

        </html>