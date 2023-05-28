type Props = {
  categories: {
    [user: string]: string[];
  };
};

export default function TopNavBar({ categories }: Props) {
  return (
    <div className="xl:hidden border-2 border-blue-500">
      <p>top navbar</p>
    </div>
  );
}
