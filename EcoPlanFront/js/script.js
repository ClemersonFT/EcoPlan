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
    const scroll = window.scrollY;

    const blur = Math.max(0, 10 - scroll / 50);
    heroimg.style.filter = `blur(${blur}px)`;

    const opacity = Math.max(0, 1 - scroll / 300);
    direcionamento.style.opacity = opacity;
    direcionamento.style.pointerEvents = opacity > 0.05 ? "auto" : "none";

    const textoOpacity = Math.min(1, scroll / 400);
    apresentacao.style.opacity = textoOpacity;
    introducao.style.opacity = textoOpacity;

    fundos.forEach(f => f.style.opacity = textoOpacity);
    opcoes.forEach(opcao => opcao.style.opacity = textoOpacity);
}

window.addEventListener("scroll", atualizarScroll);
window.addEventListener("load", atualizarScroll);

botao.addEventListener("click", () => {
    const isNarrow = window.matchMedia("(max-width: 1200px)").matches;
    const destino = document.querySelector(isNarrow ? "#secao-opcoes" : "#contato");

    destino.scrollIntoView({
        behavior: "smooth",
        block: "start"
    });
});

botaoLogin.addEventListener("click", (e) => {
    e.preventDefault();
    modal.classList.add("ativo");
});

window.addEventListener("click", (e)=>{
    if(e.target === modal){
        modal.style.display = "none";
    }
});

botaoLogin.addEventListener("click", (e)=>{
    e.preventDefault();
    modal.classList.add("ativo");
});

modal.addEventListener("click", (e) => {
    if (e.target === modal) {
        modal.classList.remove("ativo");
    }
});