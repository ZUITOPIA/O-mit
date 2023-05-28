"use client";

import { useState } from "react";
import AddStudyModal from "./AddStudyModal";
import Modal from "./Modal";

export default function AddStudy() {
  const [showModal, setShowModal] = useState(false);

  return (
    <div className="flex flex-col p-3">
      <button
        onClick={() => setShowModal(true)}
        className="text-sm text-gray300 flex justify-end cursor-auto"
      >
        + Add a study
      </button>
      {showModal && (
        <Modal>
          <AddStudyModal closeModal={() => setShowModal(false)} />
        </Modal>
      )}
    </div>
  );
}
