import React from "react";
import ReactDOM from "react-dom/client";
import UserApp from "@/components/UserApp";

const domContainer = document.getElementById("root");
const root = ReactDOM.createRoot(domContainer);
root.render(
    <React.StrictMode>
        <UserApp />
    </React.StrictMode>
    );
