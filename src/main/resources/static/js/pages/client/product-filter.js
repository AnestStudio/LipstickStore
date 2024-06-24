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
}

function displaySelectedFilterTags() {
  let html = "";
  array.forEach(e => {
    html += `
      <span class="tag badge align-items-center text-danger-emphasis bg-danger-subtle">
        <span class="ps-1 pe-2">${e}</span>
        <a href="javascript:void(0)" onclick="remoteSelectedFilterTag('${e}')">
          <i class="bi bi-x-lg"></i>
        </a>
      </span>
    `;
  });
  document.getElementById("tagList").innerHTML = html;
}

function remoteSelectedFilterTag(value) {
  let index = array.indexOf(value);
  if (index !== -1) {
    array.splice(index, 1);
  }
  displaySelectedFilterTags();
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

  displaySelectedFilterTags();
}


/*
 * TAGS FILTER ---------------------------------------------------------------------------------------------------------
 */

let scrollPosition = 0;

function scrollTags(direction) {
  const tagList = document.getElementById('tagList');
  const prevBtn = document.getElementById('prevBtn');
  const nextBtn = document.getElementById('nextBtn');
  const tagWidth = tagList.querySelector('.tag').offsetWidth + 10;
  const visibleTags = Math.floor(tagList.parentElement.offsetWidth / tagWidth);

  if (direction === 'next') {
    scrollPosition -= tagWidth * visibleTags;
  } else {
    scrollPosition += tagWidth * visibleTags;
  }

  const maxScroll = -(tagList.scrollWidth - tagList.parentElement.offsetWidth);

  if (scrollPosition > 0) {
    scrollPosition = 0;
  }

  if (scrollPosition < maxScroll) {
    scrollPosition = maxScroll;
  }

  tagList.style.transform = `translateX(${scrollPosition}px)`;

  // Update button visibility
  prevBtn.style.display = (scrollPosition < 0) ? 'flex' : 'none';
  nextBtn.style.display = (scrollPosition > maxScroll) ? 'flex' : 'none';
}

// Initial check for button visibility
window.onload = () => {
  const tagList = document.getElementById('tagList');
  const prevBtn = document.getElementById('prevBtn');
  const nextBtn = document.getElementById('nextBtn');
  const maxScroll = -(tagList.scrollWidth - tagList.parentElement.offsetWidth);

  prevBtn.style.display = 'none';
  nextBtn.style.display = (maxScroll < 0) ? 'flex' : 'none';
}
