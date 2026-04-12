# Airport Database Tool

A Java tool that automatically downloads all airport CSV data from [ourairports.com](https://ourairports.com/data), parses it, and imports it into a MySQL/MariaDB database.

## Overview

The tool imports the following datasets:

| Dataset | Description |
|---|---|
| `airports` | Airport details (IATA/ICAO codes, coordinates, type, etc.) |
| `airport_frequencies` | Radio frequencies per airport |
| `countries` | Country data with continent assignment |
| `regions` | Region data |
| `runways` | Runway details (length, surface, lighting, etc.) |
| `navaids` | Navigation aids (VOR, NDB, ILS, etc.) |

## Requirements

- Java 17+
- Maven 3.8+
- MySQL or MariaDB (local or via Docker)
- Git

> **Windows users** without Git, Docker, Maven or Java:
> - Git: https://git-scm.com/downloads
> - Docker Desktop: https://www.docker.com/products/docker-desktop/

## Project Structure

```
airportDatabase/
├── docker/
│   └── docker-compose.yml        # MariaDB + phpMyAdmin + app container
├── resources/
│   └── config/
│       ├── downloadLinks.ini             # Download URLs for CSV files
│       └── exampleConfigSqlExecution.ini # Example DB config
└── src/
    └── main/java/rentasad/tools/airportsDatabase/
        ├── CreateAirportDatabaseMain.java  # Entry point
        ├── AirportImportService.java       # Import orchestration
        ├── AirportDatabaseTool.java        # DB operations
        └── ParseAirportCsvFilesModul.java  # CSV parsing
```

## Setup & Configuration

### 1. Clone the repository

```bash
git clone https://github.com/rentasad/airportDatabase.git
cd airportDatabase
```

### 2. Configure the database connection

Copy the example config and adjust your database credentials:

```bash
cp resources/config/exampleConfigSqlExecution.ini resources/config/configSqlExecution.ini
```

Edit `resources/config/configSqlExecution.ini` and set your MySQL connection details (host, port, user, password, database).

### 3. Download links (optional)

The file `resources/config/downloadLinks.ini` contains the download URLs for the CSV files from ourairports.com. These are preconfigured and do not normally need to be changed.

## Running the Application

### Option A: With Docker Compose (recommended)

The `docker/docker-compose.yml` sets up:
- **MariaDB** on port `3306`
- **phpMyAdmin** on port `8080`
- **Airport Database Creator** (Maven build + run)

```bash
cd docker

# Start in foreground
docker compose up

# Start in background
docker compose up -d
```

After startup, phpMyAdmin is available at: http://localhost:8080

Default credentials: `root` / `notSecureChangeMe`

> **Note:** Change the password before any productive use.

To stop the containers:
```bash
# Foreground: press Ctrl+C
# Background:
docker compose down
```

### Option B: Local Maven build

```bash
mvn compile exec:java
```

The main class is `rentasad.tools.airportsDatabase.CreateAirportDatabaseMain`.

## How It Works

1. **Download** — CSV files are fetched from ourairports.com into `resources/download/`
2. **Parse** — CSV files are parsed into Java model objects using OpenCSV
3. **Create schema** — SQL scripts are executed to create the database tables
4. **Import** — Data is inserted in batches of 4,000 records for performance

## Dependencies

| Library | Version | Purpose |
|---|---|---|
| OpenCSV | 5.12.0 | CSV parsing |
| MySQL Connector/J | 8.0.33 | MySQL JDBC driver |
| SQLite JDBC | 3.51.3.0 | SQLite support |
| Apache Commons IO | 2.17.0 | File utilities |
| Apache Commons Configuration2 | 2.13.0 | INI file parsing |
| Log4j 2 | 2.20.0 | Logging |
| Lombok | 1.18.36 | Boilerplate reduction |

## Version

Current version: **0.2.0**

Data source: [https://ourairports.com/data](https://ourairports.com/data)
