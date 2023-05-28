import { Noto_Sans } from "next/font/google";
import localFont from "next/font/local";

export const notoSans = Noto_Sans({
  subsets: ["latin"],
  weight: ["100", "200", "300", "400", "500", "600", "700", "800", "900"],
});

export const impact = localFont({ src: "./assets/impact.ttf" });
