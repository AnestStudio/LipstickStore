function setSelected(id, attr, array) {
  const checkboxes = document.querySelectorAll(`#${id} input[type="checkbox"]`);
  const values = array.split(',');
  checkboxes.forEach(checkbox => {
    if (values.includes(checkbox.value)) {
      checkbox.checked = true;

      const obj = {
        type: attr,
        value: checkbox.value,
        text: checkbox.getAttribute(attr)
      }
      getSelectedFilterTags(id, obj);
    }
  });
}

function openCollapse(id) {
  const element = document.querySelector(`[data-bs-target="#${id}"]`);
  element.setAttribute("aria-expanded", "true");
  document.getElementById(id).classList.add("show");
}

let tags = [];

function getSelectedFilterTags(id, obj) {
  switch (id) {
    case "brandList":
      obj.text = "Thương hiệu: " + obj.text;
      break;
    case "categoryList":
      obj.text = "Thể loại: " + obj.text;
      break;
  }
  tags.push(obj);
}

function displaySelectedFilterTags() {
  let html = "";
  tags.forEach(e => {
    html += `
      <span class="tag badge align-items-center text-danger-emphasis bg-danger-subtle">
        <span class="ps-1 pe-2">${e.text}</span>
        <a href="javascript:void(0)" onclick="remoteSelectedFilterTag('${e.text}')">
          <i class="bi bi-x-lg"></i>
        </a>
      </span>
    `;
  });
  document.getElementById("tagList").innerHTML = html;
}

function remoteSelectedFilterTag(text) {
  let index = tags.findIndex(obj => obj.text === text);

  const obj = tags[index];
  switch (obj.type) {
    case "brand":
      window.location.href = updateQueryStringParameter(currentUrl, 'brandIds', removeValueFromString(brandIds, obj.value));
      break;
    case "category":
      window.location.href = updateQueryStringParameter(currentUrl, 'categoryIds', removeValueFromString(categoryIds, obj.value));
      break;
  }

  if (index !== -1) {
    tags.splice(index, 1);
  }
  displaySelectedFilterTags();
  updateScroll();
}

function removeValueFromString(str, value) {
  let arr = str.split(',');

  let index = arr.indexOf(value.toString());
  if (index !== -1) {
    arr.splice(index, 1);
  }
  return arr.join(',');
}

function displaySelectedFilterSidebar() {
  if (brandIds !== "" && brandIds !== null) {
    openCollapse("brand-collapse");
    setSelected("brandList", "brand", brandIds);
  }
  if (categoryIds !== "" && categoryIds !== null) {
    openCollapse("category-collapse");
    setSelected("categoryList", "category", categoryIds);
  }
  displaySelectedFilterTags();
}


/*
 * TAGS FILTER ---------------------------------------------------------------------------------------------------------
 */

let scrollPosition = 0;

function scrollTags(direction) {
  const tagList = document.getElementById("tagList");
  const prevBtn = document.getElementById("prevBtn");
  const nextBtn = document.getElementById("nextBtn");
  const tagWidth = tagList.querySelector(".tag").offsetWidth + 10;
  const visibleTags = Math.floor(tagList.parentElement.offsetWidth / tagWidth);

  if (direction === "next") {
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
  prevBtn.style.display = (scrollPosition < 0) ? "flex" : "none";
  nextBtn.style.display = (scrollPosition > maxScroll) ? "flex" : "none";
}

function updateScroll() {
  const tagList = document.getElementById("tagList");
  const prevBtn = document.getElementById("prevBtn");
  const nextBtn = document.getElementById("nextBtn");
  const maxScroll = -(tagList.scrollWidth - tagList.parentElement.offsetWidth);

  if (scrollPosition > 0) {
    scrollPosition = 0;
  }

  if (scrollPosition < maxScroll) {
    scrollPosition = maxScroll;
  }

  tagList.style.transform = `translateX(${scrollPosition}px)`;

  prevBtn.style.display = (scrollPosition < 0) ? "flex" : "none";
  nextBtn.style.display = (scrollPosition > maxScroll) ? "flex" : "none";
}

// Initial check for button visibility
window.onload = () => {
  const tagList = document.getElementById("tagList");
  const prevBtn = document.getElementById("prevBtn");
  const nextBtn = document.getElementById("nextBtn");
  const maxScroll = -(tagList.scrollWidth - tagList.parentElement.offsetWidth);

  prevBtn.style.display = "none";
  nextBtn.style.display = (maxScroll < 0) ? "flex" : "none";

  displaySearchForm();
}


/*
 * ACTION CHECKBOX -----------------------------------------------------------------------------------------------------
 */

let currentUrl = window.location.href;

function getCheckedValues(name) {
  const checkboxes = document.querySelectorAll(`input[name="${name}"]:checked`);
  const values = [];
  checkboxes.forEach((checkbox) => {
    values.push(checkbox.value);
  });

  switch (name) {
    case "brand":
      window.location.href = updateQueryStringParameter(currentUrl, 'brandIds', values.join(','));
      break;
    case "category":
      window.location.href = updateQueryStringParameter(currentUrl, 'categoryIds', values.join(','));
      break;
  }
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

function addChangeEventListener(name) {
  document.querySelectorAll(`input[name="${name}"]`).forEach((checkbox) => {
    checkbox.addEventListener("change", () => getCheckedValues(name));
  });
}

addChangeEventListener("brand");
addChangeEventListener("category");
