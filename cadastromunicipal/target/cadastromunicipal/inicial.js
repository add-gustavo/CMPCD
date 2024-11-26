document.addEventListener('DOMContentLoaded', () => {
    const baseURL = '/cadastromunicipal/relatorio';

    fetch(`${baseURL}?acao=tipo`)
        .then(response => response.json())
        .then(data => {
            const labels = data.map(item => item.label);
            const values = data.map(item => item.value);

            criarGrafico(labels, values);
        })
        .catch(error => console.error('Erro ao buscar os dados de tipo:', error));

    fetch(`${baseURL}?acao=sexo`)
        .then(response => response.json())
        .then(data => {
            const labels = data.map(item => item.label);
            const values = data.map(item => item.value);

            criarGraficoPorcentagem(labels, values);
        })
        .catch(error => console.error('Erro ao buscar os dados de sexo:', error));
});

function criarGrafico(labels, data) {
    new Chart(document.getElementById('tipo'), {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                data: data,
                backgroundColor: ['#e9c46a', '#f4a261']
            }]
        },
        options: {
            maintainAspectRatio: false,
            responsive: true,
            plugins: {
                legend: {
                    position: 'top'
                }
            }
        }
    });
}

function criarGraficoPorcentagem(labels, data) {
    new Chart(document.getElementById('sexo'), {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                data: data,
                backgroundColor: ['#2a9d8f', '#e76f51', '#264653', '#f4a261']
            }]
        },
        options: {
            maintainAspectRatio: false,
            responsive: true,
            plugins: {
                legend: {
                    position: 'top'
                },
                tooltip: {
                    callbacks: {
                        label: function (context) {
                            let value = context.raw;
                            return `${context.label}: ${value.toFixed(2)}%`;
                        }
                    }
                }
            }
        }
    });
}
