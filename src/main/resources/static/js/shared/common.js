/*!
 * COMMON
 */

const tooltipTriggerList = document.querySelectorAll("[data-bs-toggle='tooltip']");
[...tooltipTriggerList].map(tooltipTriggerEl => new bootstrap.Tooltip(tooltipTriggerEl));

const popoverTriggerList = document.querySelectorAll('[data-bs-toggle="popover"]');
[...popoverTriggerList].map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl));

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


/*
 * BOOTSTRAP COMPONENT -------------------------------------------------------------------------------------------------
 */

function openModal(modal) {
  const myModal = new bootstrap.Modal(document.getElementById(modal));
  myModal.show();
}

function showToast(id) {
  const toast = new bootstrap.Toast(document.getElementById(id));
  toast.show();
}


/*
 * SEARCH FORM ---------------------------------------------------------------------------------------------------------
 */

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


/*
 * HANDLER ERROR -------------------------------------------------------------------------------------------------------
 */

function handlerCommonError(error){
  document.getElementById("toast-error-content").innerText = "Yêu cầu chưa được thực hiện. Vui lòng thử lại sau ít phút.";
  showToast("toast-error");
}


/*
 * PAGINATION ----------------------------------------------------------------------------------------------------------
 */

function goToPage(page, size) {
  let currentUrl = window.location.href;
  currentUrl = updateQueryStringParameter(currentUrl, 'page', page);
  currentUrl = updateQueryStringParameter(currentUrl, 'size', size);
  window.location.href = currentUrl;
}

function sort(sortField, sortDir) {
  let currentUrl = window.location.href;
  currentUrl = updateQueryStringParameter(currentUrl, 'sortField', sortField);
  currentUrl = updateQueryStringParameter(currentUrl, 'sortDir', sortDir);
  window.location.href = currentUrl;
}


/*
 * UTILS ---------------------------------------------------------------------------------------------------------------
 */

function removeValueFromString(str, value) {
  let arr = str.split(',');

  let index = arr.indexOf(value.toString());
  if (index !== -1) {
    arr.splice(index, 1);
  }
  return arr.join(',');
}

function updateQueryStringParameter(uri, key, value) {
  const re = new RegExp(`([?&])${key}=.*?(&|$)`, 'i');
  const separator = uri.indexOf('?') !== -1 ? '&' : '?';
  if (uri.match(re)) {
    return uri.replace(re, `$1${key}=${value}$2`);
  } else {
    return uri + separator + key + '=' + value;
  }
}


window.addEventListener('scroll', function() {
  if (window.scrollY > 300) {
    document.querySelector('.btn-scroll-to-top').style.display = 'block';
  } else {
    document.querySelector('.btn-scroll-to-top').style.display = 'none';
  }
});

document.querySelector('.btn-scroll-to-top').addEventListener('click', function() {
  window.scrollTo({
    top: 0,
    behavior: 'smooth'
  });
  return false;
});

