window.onscroll = function () {
  if (document.body.scrollTop > 30 || document.documentElement.scrollTop > 30) {
    document.getElementById("navbar").classList.add("border-bot-shadow");
  } else {
    document.getElementById("navbar").classList.remove("border-bot-shadow");
    document.getElementById("navbar").classList.remove("border-bot-solid");
  }

  const b = document.body;
  let d = document.documentElement;
  d = (d.clientHeight) ? d : b;

  if (d.scrollTop >= 276) {
    document.getElementById("navbar").classList.add("border-bot-solid");
    document.getElementById("navbar").classList.remove("border-bot-shadow");

    document.getElementById("sub-nav").classList.add("fixed-top-sub-nav");
  }
  if (d.scrollTop < 276) {
    document.getElementById("sub-nav").classList.remove("fixed-top-sub-nav");
  }
};

function setSelected(id, attr, array) {
  const checkboxes = document.querySelectorAll('#' + id + ' input[type="checkbox"]');
  const values = array.split(',');
  checkboxes.forEach(checkbox => {
    if (values.includes(checkbox.value)) {
      checkbox.checked = true;
      getFilterList(id, checkbox.getAttribute(attr));
    }
  });
}

function openCollapse(id) {
  const element = document.querySelector('[data-bs-target="#' + id + '"]');
  element.setAttribute("aria-expanded", "true");
  document.getElementById(id).classList.add("show");
}

let array = [];
function getFilterList(id, text) {
  switch (id) {
    case "brandList":
      array.push('Thương hiệu: ' + text);
      break;
    case "categoryList":
      array.push('Thể loại: ' + text);
      break;
  }
  console.log(array);
}

function displaySelectedFilter() {
  if (brandIds !== '' && brandIds !== null) {
    setSelected("brandList", "brand", brandIds);
    openCollapse("brand-collapse");
  }

  if (categoryIds !== '' && categoryIds !== null) {
    setSelected("categoryList", "category", categoryIds);
    openCollapse("category-collapse");
  }
}
