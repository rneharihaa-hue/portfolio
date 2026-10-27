
const menuBtn = document.getElementById("menuBtn");
const navbar = document.getElementById("navbar");

// Mobile navigation menu
menuBtn.addEventListener("click", () => {
    const open = navbar.classList.toggle("open");

    menuBtn.textContent = open ? "✕" : "☰";
    menuBtn.setAttribute("aria-expanded", String(open));
});

// Close menu after clicking a navigation link
navbar.querySelectorAll("a").forEach(link => {
    link.addEventListener("click", () => {
        navbar.classList.remove("open");
        menuBtn.textContent = "☰";
        menuBtn.setAttribute("aria-expanded", "false");
    });
});

// Animated typing effect
const words = [
    "IT Student",
    "Aspiring Programmer",
    "Future IT Professional"
];

let wordIndex = 0;
let charIndex = 0;
let deleting = false;

const typing = document.getElementById("typing");

function type() {
    const word = words[wordIndex];

    typing.textContent = word.slice(0, charIndex);

    if (!deleting && charIndex < word.length) {
        charIndex++;
        setTimeout(type, 85);
    } else if (!deleting) {
        deleting = true;
        setTimeout(type, 1200);
    } else if (charIndex > 0) {
        charIndex--;
        setTimeout(type, 38);
    } else {
        deleting = false;
        wordIndex = (wordIndex + 1) % words.length;
        setTimeout(type, 250);
    }
}

type();

// Automatically update copyright year
document.getElementById("year").textContent =
    new Date().getFullYear();
