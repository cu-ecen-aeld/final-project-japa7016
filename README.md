# Ink‑Cal — Always‑On E‑Ink Desk Scheduler
*A low‑power desktop appliance that turns any Raspberry Pi into a calendar frame for desk.*

---

## 1 . Project Overview
Ink‑Cal shows your next 24 hours of calendar events on a 2.13″ e‑Paper display.  
A Raspberry Pi periodically fetches events from any CalDAV server (Nextcloud, iCloud, Google‑via‑DAV), renders a monochrome bitmap, and refreshes the panel.  
The goal is to demonstrate **full‑stack embedded development**:

* custom **frame‑buffer driver** (`fb_epd213.ko`) that drives the display over SPI  
* lightweight **daemon** that handles CalDAV, graphics, GPIO button/LED  
* UX (boots straight to the agenda, single‑button refresh, weeks of battery life)


---
## Diagram

            +---------------------------+
            | 2.13" E‑Ink Display (SPI) |
            +-----------▲---------------+
                        |
        +---------------+---------------+
        |   Raspberry Pi (Yocto OS)     |
        |  • inkcal_epaper driver (/dev/fb0)|
        |  • inkcal‑daemon  	        |
        |  • Wi‑Fi + TLS CalDAV client  |
        +-------+-----------+-----------+
                | I²C       | GPIO
       +--------+---+   +---+--------+
       |  DS3231 RTC |   | Button LED |
       +------------+   +------------+

---
## 2 . Target Build System
Yocto

---

## 3 . Hardware Platform
|Component | 
|----|
| Raspberry Pi 4 |
| Waveshare 2.13″ e‑Paper HAT | 
| DS3231 RTC module |


Raspberry Pi 4 loaned by department

---

## 4 . Open‑Source Projects Used
* **libgpiod** – user‑space GPIO handling  
* **libcurl + libxml2 + libical** *(C daemon)* **or** `python‑caldav` *(Python daemon)* – CalDAV client stack  
* **Cairo + Pango** *(C)* or **Pillow** *(Python)* – text rendering

---

## 5 . Previously Discussed Content
* Yocto, Device Drivers

---

## 6 . New Content
| Category | Item |
|----------|------|
| **Topics seen in class but not coded before** | Writing a **fbdev** driver; Device‑Tree overlays |
| **Brand‑new topics** | CalDAV protocol handling;|

---

## 7 . Shared Material
No code reused from prior semesters.  

---

## 8 . Source Code Organization
| Repo | URL | Contents |
|------|-----|----------|
| **OS / driver layer** | https://github.com/cu-ecen-aeld/final-project-japa7016 | Device‑Tree overlay, `fb_epd213.ko`, Yocto recipes |
| **Application & docs** | https://github.com/japa7016/ink-cal-application | Application |


---

## 9 . Group Overview
| Team member | Role |
|-------------|------|
| **Jainil Patel** | Kernel driver, Device‑Tree overlay, Yocto integration, documentation |
| **Parth Patel**  | CalDAV client & rendering daemon, GPIO/RTC integration, documentation |

---

## 10 . Schedule Page
Project timeline and sprint boards:  

---

*Prepared by Jainil Patel & Parth Patel — April 2025*

