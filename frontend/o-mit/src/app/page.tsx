import Image from "next/image";
import { Inter } from "next/font/google";
import FineState from "./components/FineState";
import AddStudy from "./components/AddStudy";

const inter = Inter({ subsets: ["latin"] });

export default function Home() {
    return (
        <>
            <AddStudy />
            <FineState />
        </>
    );
}
