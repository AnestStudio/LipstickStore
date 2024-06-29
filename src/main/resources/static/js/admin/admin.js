function collapseDescription(id, currentElement) {
  const element = document.querySelector("." + id + ".description");
  const currentClamp = getComputedStyle(element).getPropertyValue('-webkit-line-clamp');

  if (currentClamp === '2') {
    element.style.webkitLineClamp = "initial";
    currentElement.querySelector("i").classList.add("fa-rotate-180");
  } else {
    element.style.webkitLineClamp = '2';
    currentElement.querySelector("i").classList.remove("fa-rotate-180");
  }
}


/*
 * BRANDS --------------------------------------------------------------------------------------------------------------
 */

function confirmDeleteBrand(brandId) {
  document.getElementById("confirm-modal-content").innerText = "Xác nhận xoá thương hiệu này?";
  document.getElementById("btn-confirm-modal").href = window.location.origin + "/brand/delete/" + brandId;
  openModal("confirmModal");
}


/*
 * CATEGORY ------------------------------------------------------------------------------------------------------------
 */

function confirmDeleteCategory(categoryId) {
  document.getElementById("confirm-modal-content").innerText = "Xác nhận xoá thương hiệu này?";
  document.getElementById("btn-confirm-modal").href = window.location.origin + "/category/delete/" + categoryId;
  openModal("confirmModal");
}
