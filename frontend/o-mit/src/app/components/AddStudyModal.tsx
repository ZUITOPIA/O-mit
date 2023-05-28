type Props = {
  closeModal: () => void;
};

export default function AddStudyModal({ closeModal }: Props) {
  return (
    <div
      onClick={event => {
        if (event.target === event.currentTarget) {
          closeModal();
        }
      }}
      className="fixed top-0 left-0 flex justify-center items-center w-full h-full z-50 bg-neutral-900/70"
    >
      <div className={`w-[350px] h-22 bg-gray200 p-4 rounded-lg`}>
        <div className="flex mb-3">
          <h1 className="text-gray400 font-semibold mr-2">스터디명 :</h1>
          <input className="rounded-md text-zinc-600 font-normal text-sm px-2 w-[245px]" />
        </div>
        <div className="flex justify-between">
          <h1 className="text-gray400 font-semibold">참여자 :</h1>
          <button className="bg-gray500 w-fit px-2 h-18 rounded-md font-semibold text-xs text-gray100">
            ZUITOPIA
          </button>
          <button className="bg-white w-fit px-2 h-18 rounded-md font-semibold text-xs text-gray600">
            HAPPINE2S
          </button>
          <button className="bg-white  w-fit px-2 h-18 rounded-md font-semibold text-xs text-gray600">
            HYEJU1123
          </button>
        </div>
      </div>
    </div>
  );
}
