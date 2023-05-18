/** @type {import('tailwindcss').Config} */
module.exports = {
    content: [
        "./src/pages/**/*.{js,ts,jsx,tsx}",
        "./src/components/**/*.{js,ts,jsx,tsx}",
        "./src/app/**/*.{js,ts,jsx,tsx}",
    ],
    theme: {
        extend: {
            colors: {
                black: "#000000",
                white: "#ffffff",
                gray100: "#E9E9E9",
                gray200: "#D9D9D9",
                gray300: "#B7B7B7",
                gray400: "#9D9D9D", // 피그마 내에 959595도 이 색상 사용
                gray500: "#747474",
                gray600: "#626262",
                gray700: "#161616",
            },
            backgroundImage: {
                "gradient-radial": "radial-gradient(var(--tw-gradient-stops))",
                "gradient-conic": "conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))",
            },
        },
    },
    plugins: [],
};
