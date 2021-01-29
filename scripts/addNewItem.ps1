# PowerShell script to auto generate json files to aid in the addition of new items

if($args.Count -eq 1){
	#Write-Host $args[0].GetType().name
	if(($args[0].GetType().name -ne "String")){
		Write-Host "Bad input!"
		Write-Host "NAME must be a String!"
		Write-Host "`r"
		exit 0
	}
}elseif($args.Count -eq 2){
	if(($args[1].GetType().name -ne "String")){
		Write-Host "Bad input!"
		Write-Host "TOOLTIP must be a String!"
		Write-Host "`r"
		exit 0
	}
}else{
	Write-Host "Bad input!"
	Write-Host "Program expects a STRING_NAME followed by an optional STRING_TOOLTIP"
	Write-Host "`r"
	exit 0
}

# End usage message and input sanitation code

$name = $args[0]
$tooltip = $args[1]

$tooltip_exists =  $null -eq $tooltip
$tooltip_exists = !$tooltip_exists

if($tooltip_exists){
	Write-Host $name": "$tooltip
}else{
	Write-Host "Not adding tooltip for"$name
}


$file = ".json"
$full_name = -join($name, $file)
$base_path = "D:\Minecraft Mods\Rings\src\main\resources\assets\rings\models\item\"
$item_path = -join($base_path, $full_name)

$item_file_exists = Test-Path $item_path

if($item_file_exists){
	Write-Host "File exists! Not creating nor overwriting file."
}else{

	Write-Host "No such file exists! Creating new file."
	New-Item $item_path

	$layer_path = "rings:items/"
	$layer_path = -join($layer_path, $name)

	$sub_info = "" | Select-Object layer0
	$sub_info.layer0 = $layer_path

	$info = "" | Select-Object parent,textures
	$info.parent = "item/generated"
	$info.textures = $sub_info

	$json = @()
	$json += $info
	$json | ConvertTo-Json | Out-File $item_path

	######
}

	$item_string = "item.rings."
	$item_string = -join($item_string, $name)
	$item_string = $item_string.ToString().ToLower()
	$tooltip_string = ".tooltip"

	if($tooltip_exists){
		$tooltip_string = -join($item_string, $tooltip_string)
	}

	$lang_path = "D:\Minecraft Mods\Rings\src\main\resources\assets\rings\lang\en_us.json"
	$lang = Get-Content -Path $lang_path
	$item_in_lang = 0
	$num_lines_in_lang = 0

	foreach ($element in $lang){
		if($element.Contains($item_string)){
			$item_in_lang = 1
		}
		$num_lines_in_lang++
	}
	
	$num_items_in_lang = $num_lines_in_lang - 2 # accounts for the two braces

	if($item_in_lang){
		Write-Host "Item already registered in lang as `"$($item_string)`"!"
		Write-Host "`r"
		exit 0
	}else{
		if($tooltip_exists){
			Write-Host "`"$($item_string)`" not found in lang file! Registering `"$($item_string)`" as a new item!"
			Write-Host "Item has tooltip! Adding entry for `"$($tooltip_string)`"!"
		}else{
			Write-Host "`"$($item_string)`" not found in lang file! Registering as a new item!"
		}
	}
<#
	$json_item = ($name.ToString().ToLower() -replace "_", " ")
	$json_item = (Get-Culture).TextInfo.ToTitleCase($json_item)
	$json_tooltip = $tooltip
	$json_tag = "item.rings.$($name.ToString().ToLower())"

	$lang = ($lang[0..($lang.count - 2)])

	$addition += "  `"$json_tag`": "
	$addition += "`"$($json_item)`""

	Set-Content -Path $lang_path $lang"," ##THIS WORKS BUT IT'S SHIT
	Add-Content -Path $lang_path $addition
	Add-Content -Path $lang_path "}"
#>
	Write-Host "`r"
exit