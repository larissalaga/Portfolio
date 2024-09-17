function esconder_imagem() {
  const botao = document.getElementById('imgbotao');
  console.log(botao.style.display);
  if (botao.style.display === 'none') {
    botao.style.display = 'flex';
  } else {
    botao.style.display = 'none';
  }
}
