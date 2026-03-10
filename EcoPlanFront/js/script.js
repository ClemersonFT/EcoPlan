const heroimg = document.querySelector(".hero-img");
const direcionamento = document.querySelector(".direcionamento");
const apresentacao = document.querySelector(".apresentacao");
const introducao = document.querySelector(".introducao");
const fundos = document.querySelectorAll(".fundo");
const opcoes = document.querySelectorAll(".opcao");
const botaoLogin = document.querySelector(".login");
const modal = document.querySelector("#login-modal");
const botao = document.querySelector("#botao-contato");

function atualizarScroll() {
    let scroll = window.scrollY;
    let blur = 10 - scroll / 50;
    if (blur < 0) blur = 0;
    heroimg.style.filter = `blur(${blur}px)`;
    let opacity = 1 - scroll / 300;
    if (opacity < 0) opacity = 0;
    direcionamento.style.opacity = opacity;
    let textoOpacity = scroll / 400;
    if (textoOpacity > 1) textoOpacity = 1;
    apresentacao.style.opacity = textoOpacity;
    introducao.style.opacity = textoOpacity;

    fundos.forEach(f => {
        f.style.opacity = textoOpacity;
    });

    opcoes.forEach(opcao => {
        opcao.style.opacity = textoOpacity;
    });
}
window.addEventListener("scroll", atualizarScroll);
window.addEventListener("load", atualizarScroll);

botao.addEventListener("click", () => {

    const destino = document.querySelector("#contato");

    destino.scrollIntoView({
        behavior: "smooth"
    });

});

botaoLogin.addEventListener("click", (e)=>{
    e.preventDefault();
    modal.style.display = "flex";
});

window.addEventListener("click", (e)=>{
    if(e.target === modal){
        modal.style.display = "none";
    }
});p

botaoLogin.addEventListener("click", (e)=>{
    e.preventDefault();
    modal.classList.add("ativo");
});

modal.addEventListener("click", (e)=>{
    if(e.target === modal){
        modal.style.display = "none";
    }
});
