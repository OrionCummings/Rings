# PowerShell script to auto generate json files to aid in the addition of new blocks

$name = "TEST_BLOCK"
$file = ".json"
$full_name = -join($name, $file)

$blockstates_path = "D:\Minecraft Mods\Rings\src\main\resources\assets\rings\blockstates\"
$block_path = "D:\Minecraft Mods\Rings\src\main\resources\assets\rings\models\block\"
$item_path = "D:\Minecraft Mods\Rings\src\main\resources\assets\rings\models\item\"

$blockstates_path = -join($blockstates_path, $full_name)
$block_path = -join($block_path, $full_name)
$item_path = -join($base_path, $full_name)

$blockstates_file_exists = Test-Path $blockstates_path
$block_file_exists = Test-Path $block_path
$item_file_exists = Test-Path $item_path

if($blockstates_file_exists){
	Write-Host "File exists at "$blockstates_path"! Not creating nor overwriting file"
}else{
	Write-Host "No file exists at "$blockstates_path" Creating new file."
	New-Item $blockstates_path

	$modelString = "rings:blocks/"
	$modelString = -join($modelString, $name)

	$sub2_info = "model" | Select-Object model
	$sub2_info.model = $modelString

	#???????
	$sub_info = "" | Select-Object ABCDEFG
	$sub_info.ABCDEFG = $sub2_info

	$info = "" | Select-Object variants
	$info.variants = $sub_info

	$json = @()

	$sub_info += $sub2_info
	$info += $sub_info

	$json += $info

	$json | ConvertTo-Json | Out-File $blockstates_path

	#DUMB REGEX HACK
	$block_states_content = (Get-Content -Path $blockstates_path)

	#THIS IS THE WORST THING IVE EVER MADE LOL
	$json = $block_states_content -replace "ABCDEFG", ""

	Write-Host $json
	$json | Out-File $blockstates_path
}


if($block_file_exists){
	Write-Host "File exists at "$block_path"! Not creating nor overwriting file"
}else{

	Write-Host "No file exists at "$block_path" Creating new file."

	$allString = "rings:blocks/"
	$allString = -join($allString, $name)
	$parentString = "block/cube_all" #constant for cube blocks

	$sub_info = "textures" | Select-Object all
	$sub_info.all = $allString

	$info = "" | Select-Object parent,textures
	$info.parent = $parentString
	$info.textures = $sub_info

	$json = @()
	$json += $info

	$json | ConvertTo-Json | Out-File $block_path
}

if($item_file_exists){
	Write-Host "File exists at "$item_path"! Not creating nor overwriting file"
}else{

	Write-Host "No file exists at "$item_path" Creating new file."

	$parentString = "rings:block/"
	$parentString = -join($parentString, $name)

	$info = "" | Select-Object parent
	$info.parent = $parentString

	$json = @()
	$json += $info
	$json | ConvertTo-Json | Out-File $item_path
}