/*!
 * Common
 */

const tooltipTriggerList = document.querySelectorAll("[data-bs-toggle='tooltip']");
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl));

window.onscroll = () => {
  if (document.body.scrollTop > 30 || document.documentElement.scrollTop > 30) {
    document.getElementById("navbar").classList.add("border-bot-shadow");
  } else {
    document.getElementById("navbar").classList.remove("border-bot-shadow");
  }
}

window.onload = () => {
  displaySearchForm();
}

function openModal(modal) {
  const myModal = new bootstrap.Modal(document.getElementById(modal));
  myModal.show();
}

function showToast(id) {
  const toast = new bootstrap.Toast(document.getElementById(id));
  toast.show();
}

function displaySearchForm() {
  const pathname = window.location.pathname;
  if (pathname === "/products" || (/^\/lipstick\/detail\/.*$/.test(pathname))) {
    const element = document.getElementById("search-product");
    if (element) {
      element.style.display = "block";
    }
  }
}

function showSearchForm(e) {
  if (e.ctrlKey) {
    if (e.key === "q" || e.key === "Q") {
      openModal("searchModal");
    }
  }
}

function handlerCommonError(error){
  document.getElementById("toast-error-content").innerText = "Yêu cầu chưa được thực hiện. Vui lòng thử lại sau ít phút.";
  showToast("toast-error");
}
