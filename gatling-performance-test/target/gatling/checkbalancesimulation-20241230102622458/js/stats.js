var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name--1146707516",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "1410",
        "ok": "1374",
        "ko": "36"
    },
    "minResponseTime": {
        "total": "45",
        "ok": "45",
        "ko": "211"
    },
    "maxResponseTime": {
        "total": "1415",
        "ok": "196",
        "ko": "1415"
    },
    "meanResponseTime": {
        "total": "82",
        "ok": "72",
        "ko": "473"
    },
    "standardDeviation": {
        "total": "84",
        "ok": "17",
        "ko": "328"
    },
    "percentiles1": {
        "total": "69",
        "ok": "69",
        "ko": "333"
    },
    "percentiles2": {
        "total": "78",
        "ok": "77",
        "ko": "545"
    },
    "percentiles3": {
        "total": "116",
        "ok": "99",
        "ko": "1212"
    },
    "percentiles4": {
        "total": "378",
        "ok": "144",
        "ko": "1415"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 1374,
    "percentage": 97.44680851063829
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0.0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 0,
    "percentage": 0.0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 36,
    "percentage": 2.553191489361702
},
    "meanNumberOfRequestsPerSecond": {
        "total": "17.2",
        "ok": "16.76",
        "ko": "0.44"
    }
},
contents: {
"req_check-balance-r-1395626451": {
        type: "REQUEST",
        name: "Check Balance Request",
path: "Check Balance Request",
pathFormatted: "req_check-balance-r-1395626451",
stats: {
    "name": "Check Balance Request",
    "numberOfRequests": {
        "total": "1410",
        "ok": "1374",
        "ko": "36"
    },
    "minResponseTime": {
        "total": "45",
        "ok": "45",
        "ko": "211"
    },
    "maxResponseTime": {
        "total": "1415",
        "ok": "196",
        "ko": "1415"
    },
    "meanResponseTime": {
        "total": "82",
        "ok": "72",
        "ko": "473"
    },
    "standardDeviation": {
        "total": "84",
        "ok": "17",
        "ko": "328"
    },
    "percentiles1": {
        "total": "69",
        "ok": "69",
        "ko": "333"
    },
    "percentiles2": {
        "total": "78",
        "ok": "77",
        "ko": "545"
    },
    "percentiles3": {
        "total": "116",
        "ok": "99",
        "ko": "1212"
    },
    "percentiles4": {
        "total": "378",
        "ok": "144",
        "ko": "1415"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 1374,
    "percentage": 97.44680851063829
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t >= 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0.0
},
    "group3": {
    "name": "t >= 1200 ms",
    "htmlName": "t >= 1200 ms",
    "count": 0,
    "percentage": 0.0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 36,
    "percentage": 2.553191489361702
},
    "meanNumberOfRequestsPerSecond": {
        "total": "17.2",
        "ok": "16.76",
        "ko": "0.44"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
