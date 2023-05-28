import AddStudy from "../AddStudy";
import FineState from "../FineState";

type Props = {
  categories: {
    [user: string]: string[];
  };
};

export default function AsideNavBar({ categories }: Props) {
  return (
    <section>
      <div className={"hidden xl:block m-4 p-4 bg-[#e9e9e9] rounded-md"}>
        {Object.entries(categories).map(([key, value]) => (
          <ul className="w-full" key={key}>
            <h3 className="text-base font-semibold text-[#959595] p-2">
              {key}
            </h3>
            {value.length !== 0 &&
              value.map((category, index) => (
                <li
                  className="max-w-[13rem] whitespace-nowrap text-ellipsis overflow-hidden font-semibold text-[#959595] mx-2 p-2"
                  key={index}
                >
                  {category}
                </li>
              ))}
          </ul>
        ))}
        <hr className="w-full border-0.5 border-[#959595] m-2" />
        <h3 className="text-base font-semibold text-[#959595] p-2">TAGS</h3>
      </div>
      <AddStudy />
      <FineState />
    </section>
  );
}
