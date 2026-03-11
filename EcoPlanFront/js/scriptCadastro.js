const form = document.querySelector("#signup-form");
const senha = document.querySelector("#senha");
const confirmar = document.querySelector("#confirmar");

const errSenha = document.querySelector("#err-senha");
const errConfirmar = document.querySelector("#err-confirmar");

function setError(el, msg) {
  el.textContent = msg || "";
}

function validarSenhasIguais() {
  if (!senha.value || !confirmar.value) {
    setError(errConfirmar, "");
    return true;
  }
  if (senha.value !== confirmar.value) {
    setError(errConfirmar, "As senhas não conferem.");
    return false;
  }
  setError(errConfirmar, "");
  return true;
}

confirmar.addEventListener("input", validarSenhasIguais);
senha.addEventListener("input", validarSenhasIguais);

form.addEventListener("submit", (e) => {
  let ok = true;

  if (!form.checkValidity()) ok = false;

  if (!validarSenhasIguais()) ok = false;

  if (!ok) {
    e.preventDefault();

    if (senha.validity.tooShort) {
      setError(errSenha, "A senha precisa ter pelo menos 6 caracteres.");
    } else {
      setError(errSenha, "");
    }

    form.reportValidity();
  }
});
