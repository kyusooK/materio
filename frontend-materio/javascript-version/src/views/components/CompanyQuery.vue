<template>
    <v-card style="border-radius: 0; margin-top:10px; padding-bottom:10px; background-color: #F4F5FA;">
        <v-card-title>
            회사검색
        </v-card-title>
    
        <v-card-text style="margin-top:-30px;">
            <v-row no-gutters style="margin: 15px 0px -10px -15px;">
                <v-col style="max-width:140px;">
                    <String class="attributes-list" label="이름" v-model="value.parameters.name" :editMode="editMode"/>
                </v-col>
                <v-col style="max-width:140px;">
                    <String class="attributes-list" label="산업" v-model="value.parameters.industry" :editMode="editMode"/>
                </v-col>
                <v-col>
                    <v-btn class="gs-query-search-btn contrast-primary-text"
                        @click="search"
                        small
                        style="margin-left: 15px; margin-top: 20px;"
                        color="primary"
                    >
                        <v-icon small>mdi-magnify</v-icon>검색
                    </v-btn>
                </v-col>
            </v-row>
        </v-card-text>
    </v-card>
</template>

<script>
import String from './primitives/String.vue'
    export default {
        name: 'CompanyQuery',
        components:{
            String
        },
        props: {},
        data: () => ({
            editMode: true,
            value: {
                apiPath: 'companies/search/findByCompanyQuery',
                parameters: {}
            },
        }),
        created() {
        },
        watch: {
        },
        methods: {
            search() {
                let search = null;
                search = this.value;
                this.$emit('search', search);
            },
            change() {
                this.$emit("update:modelValue", this.value);
            },
        }
    }
</script>
<style>
.attributes-list{
    margin-left: 15px;
}
</style>

