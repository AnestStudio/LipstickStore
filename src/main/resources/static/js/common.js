/*!
 * Common
 */

const tooltipTriggerList = document.querySelectorAll('[data-bs-toggle="tooltip"]');
const tooltipList = [...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl));

window.onscroll = function () {
  const b = document.body;
  let d = document.documentElement;
  d = (d.clientHeight) ? d : b;

  if (d.scrollTop >= 382) {
    document.getElementById("sub-nav").classList.add("fixed-top");
    document.getElementById("products").classList.add("fix-sub-nav");
  }
  if (d.scrollTop < 382) {
    document.getElementById("sub-nav").classList.remove("fixed-top");
    document.getElementById("products").classList.remove("fix-sub-nav");
  }
};

function openModal(modal) {
  const myModal = new bootstrap.Modal(document.getElementById(modal));
  myModal.show();
}

function showToast(id) {
  const toast = new bootstrap.Toast(document.getElementById(id));
  toast.show();
}

function showSearchForm(e) {
  if (e.ctrlKey) {
    if (e.key === "q" || e.key === "Q") {
      openModal("searchModal");
    }
  }
}
