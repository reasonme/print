<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>传票页面</title>
    <link href="summon.css" rel="stylesheet" type="text/css"/>
    <style>
        #company {
            text-align: center;
            font-size: 22px;
        }

        #name {
            text-align: center;
            font-size: 24px;
        }

        #end {
            text-align: center;
        }

        body {
            font-family: SimSun;
        }
    </style>
</head>
<body>
<div id="company">${courtName}</div>

<p id="name">传 &#160; &#160;票</p>
<form method="post" action="">
    <table border="1" bordercolor="#0099ff" cellpadding="10px" cellspacing="0" align="center">
        <tr style="text-align:center;">
            <td>案   号</td>
            <td>
                <span align="middle">(${casenumName})</span>
                <span align="middle">(${casenumWord})字</span>
                <span align="middle">第${casenumCount}号</span>
            </td>
        </tr>
        <tr style="text-align:center;">
            <td>案   由</td>
            <td>${caseReason}</td>
        </tr>
        <tr style="text-align:center;">
            <td>被传唤人</td>
            <td>${calledPerson}</td>
        </tr>
        <tr style="text-align:center;">
            <td>工作单位或地址</td>
            <td>${calledAddress}</td>
        </tr>
        <tr style="text-align:center;">
            <td>传唤事由</td>
            <td>${calledThing}</td>
        </tr>
        <tr style="text-align:center;">
            <td>应到时间</td>
            <td style="align-items: center">
                <span align="middle">${arrivalsYear}年</span>
                <span align="middle">${arrivalsMonth}月</span>
                <span align="middle">${arrivalsDay}日</span>
                <span align="middle">${arrivalsHour}时</span>
                <span align="middle">${arrivalsMinute}分</span>
            </td>
        </tr>
        <tr style="text-align:center;">
            <td>应到住所</td>
            <td>${destination}</td>
        </tr>
        <tr>
            <td colspan="2">
                <p>注意事项: 1.被传唤人必须准时到达应到住所；</p>
                <p> &#160; &#160;&#160; &#160;2.本传票由被传唤人携带来院报到；</p>
                <p> &#160; &#160;&#160; &#160;3.被传唤人收到传票后，应在送达回证上签名或盖章。</p>
                <br/>
                <p>&#160; &#160;&#160; &#160;&#160; &#160; &#160;&#160; &#160;&#160; &#160;&#160; &#160;审判员：${judge}</p>
                <p>&#160; &#160;&#160; &#160;&#160; &#160; &#160;&#160; &#160;&#160; &#160; &#160;&#160;书记员：${clerk}</p>
                <p>&#160; &#160;&#160; &#160;&#160; &#160;&#160; &#160;&#160; &#160; &#160; &#160;&#160;${callYear}年${callMonth}月${callDay}日</p>
                <p>&#160; &#160;&#160; &#160;&#160; &#160;&#160; &#160;&#160; &#160;&#160; &#160;&#160; &#160;（院印）</p>
            </td>
        </tr>
    </table>
    <p id="end">本联送到被传唤人</p>
</form>
</body>
</html>