const toggleBtn = document.querySelector('.navbar_toggle_btn');
const name = document.querySelector('.navbar_name');


toggleBtn.addEventListener('click', () => {
    name.classList.toggle('active');
})