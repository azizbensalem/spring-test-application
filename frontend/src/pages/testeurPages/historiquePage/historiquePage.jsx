import React from "react";
import LayoutComponent from "../../../components/LayoutComponent";
import TableComponent from "../../../components/TableComponent";
import TalanLogo from "../../../assets/talan-logo.png";

export default function HistoriquePage() {
  return (
    <LayoutComponent
      headerLogo={TalanLogo}
      currentPage={"2"}
      mainContent={<TableComponent />}
    ></LayoutComponent>
  );
}