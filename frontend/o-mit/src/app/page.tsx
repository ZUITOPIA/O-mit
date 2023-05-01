import Image from "next/image";
import { Inter } from "next/font/google";
import FineState from "./components/FineState";

const inter = Inter({ subsets: ["latin"] });

export default function Home() {
    return <FineState />;
}
