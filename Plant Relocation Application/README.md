# Plant Relocation (Match-Marking) Web Application and Offline Android Companion

A C# (ASP.NET Razor Pages) web application designed to visually map and manage manufacturing plant components onto detailed layouts, paired with an Android companion app (Kotlin) for offline data capture and synchronization.

---

## Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Technology Stack](#technology-stack)
4. [Folder Structure](#folder-structure)
5. [UI Screenshots](#UI-Screenshots)

---

## Overview
This project provides a **match-marking** solution where users can upload and overlay graphical elements onto high-resolution images (plant layouts) to indicate specific components, parts, and their physical locations within a manufacturing plant. The data is shared between a web application and an offline-capable Android app.

The **primary objectives** of this project are:
- To store detailed part data, including images, within an SQL database and corresponding file system.
- To facilitate precise graphical overlays on plant layouts or blueprint images.
- To enable offline data collection on Android devices with seamless synchronization when connectivity is available.

---

## Features
- **Razor Pages Architecture**: Clean separation of page logic (`.cshtml.cs`) and UI markup (`.cshtml`), improving maintainability and testability.
- **SQL Server Express**: Centralized storage of part information, plant layouts, user data, and other relevant entities.
- **File System Integration**: Store and retrieve large images from the server’s file system, reducing database load and simplifying backups.
- **Graphical Overlay**: Interactive mapping of manufacturing plant parts on large blueprint images, complete with dimension-based overlays.
- **Android Offline Companion**: Kotlin-based mobile application that operates with minimal connectivity and syncs data with the web platform.
- **Deployment**: Easily hostable on IIS (Windows Server) or via Azure App Services.

---

## Technology Stack
- **Backend**: C#, ASP.NET Core Razor Pages
- **Database**: SQL Server Express
- **Frontend**: HTML, CSS, and Razor syntax
- **Android Mobile**: Kotlin
- **Hosting**: IIS / Azure

---

## Folder Structure

```plaintext
MyProject/
│
├── Pages
│   ├── Account
│   │   ├── Login.cshtml
│   │   ├── Login.cshtml.cs
│   │   ├── Register.cshtml
│   │   ├── Register.cshtml.cs
│   ├── Projects
│   │   ├── NewProject.cshtml
│   │   ├── NewProject.cshtml.cs
│   │   ├── ManageProject.cshtml
│   │   ├── ManageProject.cshtml.cs
│   └── ...
│   ├── Index.cshtml
│   ├── Index.cshtml.cs
│
├── Models
│   ├── Project.cs
│   ├── Entity.cs
│   ├── Type.cs
│   └── ...
│
├── wwwroot
│   └── (Static Assets: CSS, JS, Images)
│
└── ...
```
## UI Screenshots
Below are a few example screens from the Match-Mark Web Application and the Offline Android Companion. These demonstrate the app’s core functionality, such as part listing, blueprint overlay, and offline data entry. 
