import Link from "next/link";

export default function Header() {
  return (
    <section className="p-4">
      <Link href="/">
        <p className="text-4xl inline">O!mit</p>
      </Link>
    </section>
  );
}
