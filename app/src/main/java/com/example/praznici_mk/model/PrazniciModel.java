package com.example.praznici_mk.model;

public class PrazniciModel {

    private String name,   date,   monthNumber,    year,
                   month,  day,    type;

    private String documentID;


        // Constructor
        public PrazniciModel() {
        }


        // Geter - Seter
        public String getName() {
            return name;
        }
        public void   setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }
        public void   setDate(String date) {
            this.date = date;
        }

        public String getMonthNumber() {
            return monthNumber;
        }
        public void   setMonthNumber(String monthNumber) {
            this.monthNumber = monthNumber;
        }

        public String getYear() {
            return year;
        }
        public void   setYear(String year) {
            this.year = year;
        }

        public String getMonth() {
            return month;
        }
        public void   setMonth(String month) {
            this.month = month;
        }

        public String getDay() {
            return day;
        }
        public void   setDay(String day) {
            this.day = day;
        }

        public String getType() {
            return type;
        }
        public void   setType(String type) {
            this.type = type;
        }


        public String getDocumentID() {
            return documentID;
        }
        public void   setDocumentID(String documentID) {
            this.documentID = documentID;
        }
}
