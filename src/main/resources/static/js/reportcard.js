function dailyReportcard(reportData, daysInMonth) {
	var ctx = document.getElementById("dailyReportcard");
	var days = [];

	for(let i = 1; i <= daysInMonth; i++){
		days[i] = i;
	}

	var myChart = new Chart(ctx,
			{
		type : 'line',
		data : {
			labels : days,
			datasets : [{
				label : ' Expense',
				data : reportData,
				backgroundColor : 'rgba(255, 99, 132, 0.9)',
				borderColor : 'black',
				pointBackgroundColor: '#FFD166',
				pointHitRadius: 10,
				pointRadius: 10,
				borderWidth : 1,							
			}]
		},
		options : {
			responsive: true,												
			scales : {							
				yAxes : [ {
					ticks: {
						beginAtZero: true,						
						min: 0			                    
					},
					scaleLabel: {
						display: true,
						labelString: 'Expense'
					},
					gridLines : {
						color : "rgba(0, 0, 0, 0)",
					}
				} ],
				xAxes : [ {
					ticks: {			                    
						min: 1
					},
					scaleLabel: {
						display: true,
						labelString: 'Days'
					},
					gridLines : {
						color : "rgba(0, 0, 0, 0)",
					}								
				} ]
			},
			tooltips: {							
				callbacks: {
					title: function(tooltipItems, data) {			            		
						return "Day " + tooltipItems[0].xLabel;	
					},
					label: function(tooltipItem, data) {
						var label = data.datasets[tooltipItem.datasetIndex].label || '';

						if (label) {
							label += ': ₹';
						}
						label += Math.round(tooltipItem.yLabel * 100) / 100;
						return label;
					}
				}
			}
		}
			});
}

function monthlyReportcard(reportData) {
	var ctx = document.getElementById("monthlyReportcard");
	var colorList = [ 'rgba(255, 99, 132, 0.9)',
		'rgba(54, 162, 235, 0.9)',
		'rgba(255, 206, 86, 0.9)',
		'rgba(75, 192, 192, 0.9)',
		'rgba(153, 102, 255,0.9)',
		'rgba(255, 159, 64, 0.9)',
		'rgba(255, 64, 230, 0.9)',						  
		'rgba(64, 239, 255, 0.9)',
		'rgba(169, 255, 64, 0.9)',
		'rgba(64, 207, 255, 0.9)',
		'rgba(255, 64, 131, 0.9)',
		'rgba(236, 255, 64, 0.9)',
		]

	var myChart = new Chart(ctx,
			{
		type : 'bar',
		data : {
			labels : [ "Jan", "Feb", "Mar", "Apr", "May", "Jun",
				"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
				datasets : [{
					label : ' Expense',
					data : reportData,
					backgroundColor : colorList,
					borderColor : colorList,
					borderWidth : 1,							
				}]
		},
		options : {
			responsive: true,												
			scales : {							
				yAxes : [ {
					ticks: {
						beginAtZero: true,						
						min: 0
					},
					scaleLabel: {
						display: true,
						labelString: 'Expense'
					},
					gridLines : {
						color : "rgba(0, 0, 0, 0)",
					}
				} ],
				xAxes : [ {
					scaleLabel: {
						display: true,
						labelString: 'Month'
					},
					gridLines : {
						color : "rgba(0, 0, 0, 0)",
					}								
				} ]
			},
			tooltips: {							
				callbacks: {
					label: function(tooltipItem, data) {
						var label = data.datasets[tooltipItem.datasetIndex].label || '';

						if (label) {
							label += ': ₹';
						}
						label += Math.round(tooltipItem.yLabel * 100) / 100;
						return label;
					}
				}
			}
		}
			});
}

function yearlyReportcard(reportData, yearList) {
	var ctx = document.getElementById("yearlyReportcard");
	var colorList = [ 'rgba(255, 99, 132, 0.9)',
		'rgba(54, 162, 235, 0.9)',
		'rgba(255, 206, 86, 0.9)',
		'rgba(75, 192, 192, 0.9)',
		'rgba(153, 102, 255,0.9)',
		'rgba(255, 159, 64, 0.9)',
		'rgba(255, 64, 230, 0.9)',						  
		'rgba(64, 239, 255, 0.9)',
		'rgba(169, 255, 64, 0.9)',
		'rgba(64, 207, 255, 0.9)',
		]

	var myChart = new Chart(ctx,
			{
		type : 'bar',
		data : {
			labels : yearList,
				datasets : [{
					label : ' Expense',
					data : reportData,
					backgroundColor : colorList,
					borderColor : colorList,
					borderWidth : 1,							
				}]
		},
		options : {
			responsive: true,												
			scales : {							
				yAxes : [ {
					ticks: {
						beginAtZero: true,						
						min: 0
					},
					scaleLabel: {
						display: true,
						labelString: 'Expense'
					},
					gridLines : {
						color : "rgba(0, 0, 0, 0)",
					}
				} ],
				xAxes : [ {
					scaleLabel: {
						display: true,
						labelString: 'Year'
					},
					gridLines : {
						color : "rgba(0, 0, 0, 0)",
					}								
				} ]
			},
			tooltips: {							
				callbacks: {
					title: function(tooltipItems, data) {			            		
						return "Year " + tooltipItems[0].xLabel;	
					},
					label: function(tooltipItem, data) {
						var label = data.datasets[tooltipItem.datasetIndex].label || '';

						if (label) {
							label += ': ₹';
						}
						label += Math.round(tooltipItem.yLabel * 100) / 100;
						return label;
					}
				}
			}
		}
			});
}