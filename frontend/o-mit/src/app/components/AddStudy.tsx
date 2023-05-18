export default function AddStudy() {
    return (
        <div className="bg-white w-1/4 h-18 flex-col p-3">
            <h1 className="text-sm text-gray-300 flex justify-end">+ Add a study</h1>

            <div className="static">
                <div className="absolute top-[15px] left-[270px] w-3 h-4 rotate-45 bg-gray-300" />
                <div className="absolute top-0 left-[275px] w-[350px] h-22 bg-gray-300 p-4 rounded-lg">
                    <div className="flex mb-3">
                        <h1 className="text-zinc-500 font-semibold mr-2">스터디명 :</h1>
                        <input className="rounded-md text-zinc-600 font-normal text-sm px-2 w-[245px]" />
                    </div>
                    <div className="flex justify-between">
                        <h1 className="text-zinc-500 font-semibold">참여자 :</h1>
                        <button className="bg-black w-fit px-2 h-18 rounded-md font-semibold text-xs">ZUITOPIA</button>
                        <button className="bg-white w-fit px-2 h-18 rounded-md font-semibold text-xs text-zinc-500">
                            HAPPINE2S
                        </button>
                        <button className="bg-white  w-fit px-2 h-18 rounded-md font-semibold text-xs text-zinc-500">
                            HYEJU1123
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
}
