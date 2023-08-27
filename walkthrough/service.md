## Notable Mention

### Change

### สังเกต Domain Service กับ Application Service

Domain Service คนละอย่างกับ Application Service นะครับ Domain Service ใช้ในการ Model กิจกรรมใน Domain ที่ซับซ้อน ยุ่งเกี่ยวกับสิ่งของอื่นๆ (Entity) จำนวนมาก และไม่มีสิ่งของจับต้องได้มา Represent มัน

### ชื่อของ DropCar

อันนี้คือลอกจาก Verb โดยตรง แต่ต้องปรึกษากับ Domain Expert ด้วยว่าชื่อ Make sense มั้ย อาจจะมีทางเลือกอื่นแบบ CarDroppingService ก็ได้ อยากเตือนว่า Ubuiquitous langauge คือภาษาที่ใช้ร่วมกันระหว่าง Domain expert กับคนทำงานครับ

## แล้วเราจะได้ CarCollection หรือ Stock ที่ใช้มาได้ยังไง

จริงๆ ตรงนี้อาจจะแปลกใจว่าอยู่ดีๆ เราจะมีของพวกนี้มาจากไหนได้ ตอนนี้เราโมเดลให้เหมือนโลกจริงว่าการ Drop Car จะทำโดยการเอาใบ Car Collection มายืนยันใบนึงที่โรงเก็บของ เลยมี Id เป็นตัวบ่งชี้

ทำไมถึงมี Db Object แล้วมันคือส่วนไหนใน DDD เดี๋ยวเราจะได้พูดถึงเรื่องนี้ในบทถัดไปครับ

## ข้อควรระหวังใน Service

จากประสบการณ์พบว่าการมี Service เป็นเรื่องที่ไม่ปกติมากๆ เดี๋ยวจะมีคำเตือนใน Presentation ต่อไปครับ
