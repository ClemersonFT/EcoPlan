const heroBg = document.querySelector(".hero-img");
const direcionamento = document.querySelector(".direcionamento");

window.addEventListener("scroll", () => {

    let scroll = window.scrollY;

    let blur = 10 - scroll / 50;

    if (blur < 0) blur = 0;

    heroBg.style.filter = `blur(${blur}px)`;

    let opacity = 1 - scroll / 300;

    if (opacity < 0) opacity = 0;

    direcionamento.style.opacity = opacity;

});

const botao = document.querySelector("#botao-contato");

botao.addEventListener("click", () => {

    const destino = document.querySelector("#contato");

    destino.scrollIntoView({
        behavior: "smooth"
    });

});