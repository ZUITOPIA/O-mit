import Link from "next/link";

export default function Header() {
  return (
    <section className="h-[5rem] flex p-4">
      <Link href="/">
        <p className="text-4xl inline">O!mit</p>
      </Link>
    </section>
  );
}
