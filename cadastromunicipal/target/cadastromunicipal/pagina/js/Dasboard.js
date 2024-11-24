document.addEventListener('DOMContentLoaded', () => {
  // URL base para o servlet
  const baseURL = '/cadastromunicipal/relatorio';

  // Fetch e renderização dos gráficos para "tipo"
  fetch(`${baseURL}?acao=tipo`)
    .then(response => response.json()) // Converte a resposta para JSON
    .then(data => {
      // Extrai labels e valores do JSON recebido
      const labels = data.map(item => item.label);
      const values = data.map(item => item.value);

      // Chama a função para criar o gráfico de tipos de deficiência
      criarGrafico(labels, values);
    })
    .catch(error => console.error('Erro ao buscar os dados de tipo:', error));

  // Fetch e renderização dos gráficos para "sexo"
  fetch(`${baseURL}?acao=sexo`)
    .then(response => response.json()) // Converte a resposta para JSON
    .then(data => {
      // Extrai labels e valores do JSON recebido
      const labels = data.map(item => item.label);
      const values = data.map(item => item.value);

      // Chama a função para criar o gráfico de porcentagem por sexo
      criarGraficoPorcentagem(labels, values);
    })
    .catch(error => console.error('Erro ao buscar os dados de sexo:', error));
});

// Função para criar o gráfico de tipos de deficiência
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

// Função para criar o gráfico de porcentagem por sexo
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
              return `${context.label}: ${value.toFixed(2)}%`; // Formata como porcentagem
            }
          }
        }
      }
    }
  });
}
