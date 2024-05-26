document.addEventListener("DOMContentLoaded", function () {
    const faqItems = document.querySelectorAll(".faq-item");

    faqItems.forEach(function (item) {
        const question = item.querySelector(".question");
        const answer = item.querySelector(".answer");
        const icon = item.querySelector(".icon");

        question.addEventListener("click", function () {
            item.classList.toggle("active");
        });
    });
});


