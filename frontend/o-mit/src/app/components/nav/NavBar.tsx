import { getCategoryList } from "@/app/services/categories";
import AsideNavBar from "./AsideNavBar";
import TopNavBar from "./TopNavBar";

export default function NavBar() {
  const categories = getCategoryList();
  return (
    <>
      <TopNavBar categories={categories} />
      <AsideNavBar categories={categories} />
    </>
  );
}
